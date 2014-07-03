#!/bin/sh
############################################################################################
#
# start-fuse.sh - creates containers based on the environment and applies profiles to those
#					containers
#
# Usage: start-fuse.sh  <environment> <buildnumber>
#
############################################################################################

# check parameters
export env="local"
export buildnumber="1.0.0-SNAPSHOT"

FUSE_HOME="/opt/fabric8"
CREATE_FABRIC="fabric:create --new-user admin --new-user-password admin --wait-for-provisioning"

echo Using Fuse Home $FUSE_HOME
# If this is a new installation replace the commented out admin user

grep -rl "#admin" $FUSE_HOME/etc/users.properties | xargs sed -i '' "s/#admin=admin/admin=admin/g"

# enable logging
set +x

echo "Killing all karaf processes"
jps -l | grep karaf | cut -d ' ' -f 1 | xargs -n1 kill -kill

echo "Clearing down intermediate karaf data directories"
rm -rf $FUSE_HOME/data/ $FUSE_HOME/instances/ $FUSE_HOME/processes/ $FUSE_HOME/lock

echo "Launching Fuse"

($FUSE_HOME/bin/start)

i=0.0
c=0
sleeptime=1

echo -n "Waiting for Fuse to become available..."
while [ $c -le 0 ]
do
    sleep $sleeptime
    i=$(echo $sleeptime | bc)
    echo -n .
    c=$($FUSE_HOME/bin/client -u admin -p admin help 2> /dev/null| grep fabric:create | wc -l)
done

echo ""
echo "Creating a fabric"

$FUSE_HOME/bin/client -u admin -p admin -r 60 "$CREATE_FABRIC"

echo "Deploying features to fabric"

DEPLOY_SCRIPT="$(pwd)/karaf/deploy.karaf"
echo "Deploy Scripts:" $DEPLOY_SCRIPT

   $FUSE_HOME/bin/client -u admin -p admin << !
       buildnumber=$buildnumber
       shell:source $DEPLOY_SCRIPT
       exit
!