#! /bin/bash

# Function to generate QRs for a chain
generate_chain_qr() {
    local CHAIN_NAME=$1
    local RPC_URL=$2
    local RUNTIME_VERSION=$3

    echo "Generating QR codes for $CHAIN_NAME..."
    echo $pwd

    # generate specs
    cargo run load-metadata -d -u $RPC_URL

    # copy specs to for_signing
    cp "../files/in_progress/sign_me_load_metadata_${CHAIN_NAME}V${RUNTIME_VERSION}" .

    # sign specs
    SIGNATURE=$(cat sign_me_load_metadata_${CHAIN_NAME}V${RUNTIME_VERSION} | subkey sign --suri "$SIGNER_URI")
    
    # generate qr
    cargo run --release make --goal qr --crypto sr25519 --msg load-metadata --payload sign_me_load_metadata_${CHAIN_NAME}V${RUNTIME_VERSION} --verifier-hex $VERIFIER_HEX --signature-hex $SIGNATURE

    # copy qr to trait_assets
    cp "../files/completed/load_metadata_${CHAIN_NAME}V${RUNTIME_VERSION}" ../../trait_assets/load_metadata_${CHAIN_NAME}V${RUNTIME_VERSION}.png
    rm -rf "sign_me_load_metadata_${CHAIN_NAME}V${RUNTIME_VERSION}"
}

# Common variables
SIGNER_URI="<SECRET>"
VERIFIER_HEX="0x2405ad269ad0e6ca50f74226f193d7bfd1b51ef4064493c48a99f82a5a9b5374"

# Chain-specific configurations
# RELAY_RPC="ws://51.91.74.113:15260"
ASSET_HUB_RPC="wss://rpc-1.trait.tech"

cd ../rust/generate_message

# Generate QRs for relay chain
# generate_chain_qr "trait-relay" $RELAY_RPC "1000"

# Generate QRs for asset-hub chain
generate_chain_qr "trait-asset-hub" $ASSET_HUB_RPC "1002" 