def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
                    echo "building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'd95e5bec-495a-49d1-90e5-3b52c8daf1a0', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh 'docker build -t abdosalah663888/docker:jm2.0 .'
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh 'docker push abdosalah663888/docker:jm2.0'
                    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
