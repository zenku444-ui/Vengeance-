Vengeance Client — Reconstruction

«Status: Compilation complete — full build verification in progress»

This repository contains the ongoing source reconstruction of Vengeance Client, targeting Minecraft Java Edition 1.21.11 with Fabric and Java 21.

The goal is to reconstruct the original client as faithfully as possible while preserving its original classes, resources, functionality, and behavior.

---

Current Status

The current reconstruction checkpoint has:

- 207 Java source files organized under "src/main/java"
- 52 resources under "src/main/resources"
- Original project structure and Gradle configuration preserved
- "TODO.md" containing the reconstruction handoff and verification notes
- Fabric/Minecraft 1.21.11 project configuration
- Java 21 target

Build Status

The project now compiles successfully with zero Java compilation errors.

There are exactly:

0 remaining Java compilation errors

No final build should be considered successful until:

./gradlew compileJava --no-daemon

completes successfully and:

./gradlew clean build --no-daemon

produces an actual JAR.

---

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

Generated Gradle/build directories such as ".gradle/" and "build/" are not part of the source checkpoint.

---

Target Environment

Component| Target
Minecraft| 1.21.11
Mod Loader| Fabric
Java| 21
Build System| Gradle
Project Tooling| Fabric Loom

Do not change these targets unless there is a confirmed project requirement to do so.

---

Reconstruction Principles

Future work must prioritize source fidelity.

Do

- Preserve the original Vengeance functionality.
- Inspect related classes before modifying reconstructed code.
- Identify and repair decompiler/reconstruction artifacts.
- Make the smallest safe source-level changes.
- Keep existing classes, methods, fields, and resources whenever possible.
- Test compilation after logical groups of fixes.
- Document uncertain reconstruction decisions in "TODO.md".

Do Not

- Restart the reconstruction from scratch.
- Reorganize the existing "src" tree without a strong reason.
- Delete classes or features just to make compilation succeed.
- Replace functionality with empty/stub methods.
- Fake implementations simply to satisfy the compiler.
- Remove errors by hiding or suppressing them.
- Claim a successful build without actually producing a JAR.

---

Current Checkpoint

The current saved Git checkpoint is:

c8625492a26aa2be203556886d927f15debc3120

Commit message:

Vengeance reconstruction checkpoint - 100 compile errors remaining

This checkpoint should be treated as the safe restore point for the current reconstruction.

---

Continuing Development

Before making changes, read:

README.md
TODO.md

Then inspect the current compiler errors.

Start with:

./gradlew compileJava --no-daemon

Fix the errors systematically.

For each logical group of errors:

1. Understand the cause.
2. Inspect surrounding and related source.
3. Determine whether it is a reconstruction/decompiler artifact, type/mapping issue, import collision, nested-class issue, or API mismatch.
4. Make the smallest safe fix.
5. Re-run compilation.
6. Update "TODO.md" when appropriate.

After "compileJava" succeeds:

./gradlew clean build --no-daemon

A successful reconstruction requires the build command to exit with code "0" and an actual JAR to exist in the build output.

---

"TODO.md"

"TODO.md" is the primary handoff document for unresolved reconstruction issues.

Always read it before continuing work.

When fixing an issue, keep the document accurate so another developer or AI can continue the project without repeating previous work.

---

Important

This repository is a work-in-progress reconstruction.

The current source tree is intentionally preserved at a checkpoint where the reconstruction has been organized but compilation is not yet complete.

Do not interpret the existence of the Gradle project as proof that the client is fully reconstructed or build-ready.

The next objective is straightforward:

«Compilation and clean build complete while preserving the original Vengeance functionality.»
