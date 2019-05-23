# ZPI_2019_Dzienni_IO5_EEIAPany

>CI: Jenkins<br>
>Backlog: Azure Dashboards(kopia w folderze *"Backlog"*<br>

Jenkins został postawiony na dockerze przy użyciu komendy:<br>
docker run --rm -u root -p 8080:8080 -v jenkins-data:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock jenkinsci/blueocean<br>
Po wstępnym uruchomieniu(założeniu kont, pobraniu pluginów) można było postawić projekt.<br>
