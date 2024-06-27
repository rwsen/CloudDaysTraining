#!/bin/bash

# Hardcoded repository URLs
REPO_URL_BACKEND="https://github.com/EdinTC/accelerator-cloud-days-backend.git"
REPO_URL_FRONTEND="https://github.com/EdinTC/accelerator-cloud-days-frontend.git"

# Function to display usage information
usage() {
    echo "Usage: $0 [lg1|lg2]"
    exit 1
}

# Assign the first argument to BRANCH, default to 'lg1' if not provided
BRANCH=${1:-lg1}

# Validate the BRANCH argument
if [ "$BRANCH" != "lg1" ] && [ "$BRANCH" != "lg2" ]; then
    echo "Invalid branch option. Use 'lg1' or 'lg2'."
    exit 1
fi

# Function to clone and checkout a repository
clone_and_checkout() {
    local repo_url=$1
    local repo_name=$2

    echo "Cloning repository $repo_name from $repo_url to the $repo_name directory"

    # Clone the repository
    git clone "$repo_url" "$repo_name"

    # Check if the git clone was successful
    if [ $? -eq 0 ]; then
        echo "Repository $repo_name cloned successfully."
    else
        echo "Failed to clone the repository $repo_name."
        exit 1
    fi

    # Navigate to the cloned repository directory
    cd "$repo_name" || exit

    # Checkout the specified branch
    git checkout "$BRANCH"

    # Check if the git checkout was successful
    if [ $? -eq 0 ]; then
        echo "Checked out to branch $BRANCH in repository $repo_name successfully."
    else
        echo "Failed to checkout to branch $BRANCH in repository $repo_name."
        exit 1
    fi

    # Navigate back to the parent directory
    cd ..
}

# Clone and checkout the backend repository
clone_and_checkout "$REPO_URL_BACKEND" "backend"

# Clone and checkout the frontend repository
clone_and_checkout "$REPO_URL_FRONTEND" "frontend"
