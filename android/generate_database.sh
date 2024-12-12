#!/bin/bash

RELEASE_PATH=../rust/database/database_cold_release
DBPATH=./src/main/assets/Database

set -e

pushd ../rust/generate_message

# Create cold database
cargo run --locked make-cold-release
# Move metadata to cold database
cargo run transfer-meta

popd

# Move database to assets

echo "Re-creating $DBPATH"
rm -rf $DBPATH
mkdir -p $DBPATH

echo "Copying DB from $RELEASE_PATH to $DBPATH"
cp -R $RELEASE_PATH/. $DBPATH
