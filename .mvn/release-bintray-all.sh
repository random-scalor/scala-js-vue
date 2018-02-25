#!/bin/bash
set -e -u

#
# publish artifact via bintray
#

base=$(cd "${BASH_SOURCE%/*}/.." && pwd)

export RELEASE_STAMP=$(date -u +"%Y%m%d%H%M%S")

"$base/.mvn/release-bintray.sh"

"$base/demo/.mvn/release-bintray.sh"
