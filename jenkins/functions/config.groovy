def call() {
    return [
        ACR_NAME: "onpremcicdacr",
        ACR_LOGIN_SERVER: "onpremcicdacr.azurecr.io",
        IMAGE_NAME: "sample-app",
        IMAGE_TAG: "${env.BUILD_NUMBER}",
        FULL_IMAGE: "onpremcicdacr.azurecr.io/sample-app:${env.BUILD_NUMBER}",
        KUBECONFIG: "/var/jenkins_home/.kube/config",
        BUILD_DIR: "/tmp/build-${env.BUILD_NUMBER}"
    ]
}

return this