Vengeance Client — Reconstruction

«Status: Build Successful»

This repository contains the reconstructed source of Vengeance Client, targeting Minecraft Java Edition 1.21.11 with Fabric and Java 21.

The reconstruction has been organized and repaired to the point where the project compiles and produces a JAR successfully.

Current Status

- 207 Java source files under "src/main/java"
- 52 resources under "src/main/resources"
- "compileJava" succeeds with 0 errors
- "clean build" succeeds
- A functional JAR is produced by the build
- "README.md" and "TODO.md" document the current project state

Build Verification

The following commands have been successfully verified:

./gradlew compileJava --no-daemon

Result:

BUILD SUCCESSFUL
0 compilation errors

And:

./gradlew clean build --no-daemon

Result:

BUILD SUCCESSFUL

Build Artifact

The successful build produces:

vengeance-client-1.0.0.jar

Current verified artifact:

vengeance-client-1.0.0.jar
Size: 3,668,323 bytes

Target Environment

Component| Version
Minecraft| 1.21.11
Mod Loader| Fabric
Java| 21
Build System| Gradle
Project Tooling| Fabric Loom

Project Structure

.
├── src/
│   └── main/
│       ├── java/
│       │   └── <reconstructed packages and classes>
│       └── resources/
│           └── <Minecraft/Fabric resources>
│
├── gradle/
├── gradlew
├── gradlew.bat
├── build.gradle
├── gradle.properties
├── settings.gradle
├── TODO.md
└── README.md

Generated directories such as ".gradle/" and "build/" contain temporary/cache/build output and are not part of the source checkpoint.

Reconstruction Principles

The project should continue to prioritize source fidelity and preservation of the original Vengeance functionality.

Do

- Preserve existing Vengeance functionality.
- Inspect related classes before making changes.
- Make minimal, safe source-level fixes.
- Preserve existing classes, methods, fields, and resources whenever possible.
- Keep Minecraft 1.21.11, Fabric, and Java 21 aligned with the project.
- Verify changes by compiling and building the project.
- Keep "TODO.md" accurate.

Do Not

- Restart the reconstruction from scratch.
- Remove features simply to make the project compile.
- Stub or fake functionality.
- Randomly change Minecraft/Fabric versions.
- Claim a successful build without verifying the actual build output.

Previous Reconstruction Work

The source was reconstructed and organized from the original Vengeance Client project/JAR.

During the repair process, compiler and reconstruction issues were addressed, including:

- decompiler artifacts
- Yarn/mapping issues
- typed local variables
- malformed enums and records
- rendering API issues
- registry access
- utility JSON/timer code
- reconstructed nested types and related source issues

The final project was then verified with both "compileJava" and "clean build".

TODO.md

"TODO.md" remains in the repository as a historical and development handoff document.

It should be kept accurate if additional issues, cleanup, verification, or improvements are discovered.

Development

To compile the project:

./gradlew compileJava --no-daemon

To perform a clean build:

./gradlew clean build --no-daemon

A successful build should produce the Vengeance Client JAR in the configured build output location.

Current Checkpoint

The successful reconstruction state was verified at Git HEAD:

92a89d746e7e782702b9c19abaee514bbf3e503d

This represents the state where:

- compilation succeeds
- the clean build succeeds
- the JAR is produced successfully

Important

This repository represents a reconstructed version of Vengeance Client.

Although the project now compiles successfully and produces a JAR, runtime behavior should still be tested in the intended Minecraft/Fabric environment before considering every feature fully verified.

The next stage is therefore runtime testing, feature verification, and any necessary bug fixes, rather than reconstruction from scratch.
