## How to generate QR codes for the trevo assets

### Prerequisites

Before running the script, you need to set up environment variables:

1. Copy the example environment file:
```bash
cp env.example .env
```

2. Edit the `.env` file and set your actual values:
```bash
# Signer URI for QR code generation
SIGNER_URI="your_actual_signer_uri_here"

# Verifier hex for QR code generation
VERIFIER_HEX="0x2405ad269ad0e6ca50f74226f193d7bfd1b51ef4064493c48a99f82a5a9b5374"
```

**Important**: The `.env` file is excluded from git commits for security reasons. Never commit your actual signer URI to version control.

### Generating QR Codes

1. Modify the `generate_qr.sh` script to use the correct RPC URL and runtime version if needed.

2. Run the script:
```bash
./generate_qr.sh
```

3. QR codes will be generated in the `trevo_assets` folder.

### Security Notes

- The `SIGNER_URI` contains sensitive information and should never be committed to git
- The `.env` file is automatically ignored by git
- You can also use `env.local` as an alternative filename for environment variables

