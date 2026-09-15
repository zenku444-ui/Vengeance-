#!/bin/sh
set -eu
ROOT_DIR=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
if [ -x "$ROOT_DIR/gradle-8.14/bin/gradle" ]; then
    exec "$ROOT_DIR/gradle-8.14/bin/gradle" "$@"
fi
if command -v gradle >/dev/null 2>&1; then
    exec gradle "$@"
fi
echo "Gradle 8.14 is required. Install it from the distribution URL in gradle/wrapper/gradle-wrapper.properties." >&2
exit 1