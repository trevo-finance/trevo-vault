rust_dir="$(dirname "${0}")/../rust/generate_message"
pushd "$rust_dir" || exit 1
  cargo run restore-defaults
  cargo run make-cold-release
  cargo run load-metadata -p --name trait-asset-hub-runtime
  cargo run transfer-meta
popd || exit 1