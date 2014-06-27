fabric8-example-repo
====================

Fabric8 (JBoss Fuse) Web App Example:

This project provides an example of how to deploy a simple web application with Bootstrap to Fabric8 / JBoss Fuse. 
More advanced examples to come.  

Deployment: 

First build the project, navigate to the projects root dir and execute from the cli:
# mvn clean install

Add the Features repo to Fabric Profile:

If you're running a default container then the profile applied is fabric as specified in the command below, however I would recommed creating your own fabric profile. 
Via CLI:
1. # profile-edit --repositories mvn:org.fabric8.demo/fabric8-web-features/1.0.0-SNAPSHOT/xml/features fabric
2. # profile-edit --features fabric8-web-project fabric
3. # list | grep 'Fabric8 Basic Web Demo' 
If successfully deployed you should see something like: [ 146] [Active     ] [            ] [   60] Fabric8 Basic Web Demo ()
4. Open a new browser tab and navigate to: http://localhost:8181/fabric8-web-demo

Via Hawtio: (default setup)
1. Login (default is admin/admin)
2. Click on Runtime
3. Under Container sub tab click on 'root'
4. Under 'Associated Profiles' click 'fabric'
5. On the 'Feature Repositories' tab enter: mvn:org.fabric8.demo/fabric8-web-features/1.0.0-SNAPSHOT/xml/features and click add
6. Click on the 'Features' tab, and click the add feature icon at the bottom of the page
7. On the 'Edit Fabric Features' page search for 'fabrc8-web-project'
8. Click on the checkbox next to 'fabric8-web-project', click Add, Save Changes and then Done. 
9. Assuming everything deployed properly, Open a new browser tab and navigate to: http://localhost:8181/fabric8-web-demo
