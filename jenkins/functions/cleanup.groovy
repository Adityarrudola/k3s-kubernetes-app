def call(cfg) {

    sh """
    echo "Cleaning Docker..."

    # Remove old images except current + latest
    docker images --format "{{.Repository}}:{{.Tag}}" \
    | grep ${cfg.ACR_LOGIN_SERVER}/${cfg.IMAGE_NAME} \
    | grep -v "${cfg.IMAGE_TAG}" \
    | grep -v "latest" \
    | xargs -r docker rmi -f || true

    # Remove build cache
    docker builder prune -af || true

    # Aggressive cleanup
    docker system prune -af --volumes || true
    """

    sh """
    echo "Cleaning workspace..."

    rm -rf ${cfg.BUILD_DIR} || true
    """
}

return this