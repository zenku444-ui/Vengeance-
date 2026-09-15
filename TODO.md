# Vengeance Reconstruction Handoff

## Current Status

The project is organized and now compiles successfully; full clean-build verification is in progress.

Last verification command:

```bash
./gradlew compileJava --no-daemon
```

Result: **FAILED** during `:compileJava`.

Exact remaining compiler error count: **0 errors**.

The required clean build must still be verified before final completion is reported.

## Preserved Project State

- Organized Java sources: **207** files under `src/main/java/`
- Flat Java sources remaining at the project root: **0**
- Restored resource files: **52** under `src/main/resources/`
- Minecraft target: **1.21.11**
- Fabric remains configured
- Java target remains **21**
- Gradle wrapper files are present under `gradle/wrapper/`
- The wrapper distribution is configured for Gradle 9.7.0
- Existing source/resource/project changes are intentionally uncommitted and must be preserved

## Files Currently Causing Errors

The previously documented error groups have been resolved. The remaining verification record is:

- `compileJava`: successful, 0 errors
- `clean build`: successful, JAR produced under `../builds/`

Historical error groups from the checkpoint:

- `src/main/java/com/vengeance/vengeanceclient/utils/w/q/p/za.java`
  - Remaining local variable/type inference errors in the font renderer
  - Named `VertexFormat` API mismatch
  - Generic collection typing errors
- `src/main/java/com/vengeance/vengeanceclient/r/q/s/ze.java`
  - `CallbackInfoReturnable<Boolean>` receives an untyped `Object`
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/za.java`
  - Unresolved reconstructed symbols
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zaa.java`
  - Entity/HitResult type reuse errors
  - Invalid CFR `SwitchBootstraps.typeSwitch` output
  - Incorrect subtype assignments for `PlayerEntity`, `EndCrystalEntity`, and `PassiveEntity`
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zb.java`
  - Unresolved reconstructed symbol
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zc.java`
  - Remaining intermediary raycast constants and type errors
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zd.java`
  - Entity/HitResult/BlockHitResult variable reuse errors
  - Block position typing errors
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zf.java`
  - Potion contents component intermediary accessor names
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zh.java`
  - Intermediary `PlayerMoveC2SPacket.class_2829` constructor name
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zi.java`
  - Entity-hit result typing and removal-reason API issues; part of this was already corrected, so recheck current diagnostics first
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zn.java`
  - Block position/HitResult variable reuse and direction offset typing
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zo.java`
  - Entity/HitResult/BlockHitResult/BlockPos variable reuse errors
  - Raw collection typing
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zp.java`
  - Block position/HitResult variable reuse errors
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zs.java`
  - PlayerEntity stored in a HitResult-typed decompiler variable
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zt.java`
  - Vec3d stored in an Entity-typed variable
  - Raw registry item lookup typing
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zu.java`
  - Raw registry item lookup typing
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zy.java`
  - Potion contents component intermediary accessor names
- `src/main/java/com/vengeance/vengeanceclient/r/q/q/zz.java`
  - Remaining unresolved reconstructed symbol
- `src/main/java/com/vengeance/vengeanceclient/r/q/r/zd.java`
  - Focused inventory `Slot` incorrectly stored as `Screen`
  - Slot index/stack access errors
- `src/main/java/com/vengeance/vengeanceclient/r/q/t/zf.java`
  - Focused inventory slot type errors

The compiler output may show additional cascaded locations. Always fix the earliest root error first, then rerun the command.

## Already Fixed

The following work has already been completed and must not be reverted:

- All 207 flat Java uploads were placed under package-derived paths in `src/main/java/`.
- Flat collision suffixes were removed from Java filenames while preserving declared type names.
- Fabric resources and supplied assets were restored under `src/main/resources/`.
- `fabric.mod.json`, mixin configuration, and access widener were restored.
- Bundled `lombok`, `norbit`, and `orbit` JARs were restored under `src/main/resources/META-INF/jars/`.
- Gradle source/resource paths were corrected to the local `src/` tree.
- Minecraft remains `1.21.11`; Java remains `21`; Fabric remains enabled.
- Gradle wrapper configuration was created and set to Gradle `9.7.0`.
- Access widener namespace was translated from intermediary to named Yarn mappings.
- Several malformed CFR artifacts were repaired, including invalid `continue` syntax, illegal nested type names, invalid nested enums, invalid record bootstrap methods, invalid profile type-switch calls, typed Mixin callback values, Mixin target casts, Click/MouseInput accessors, and several named Minecraft API constants.
- The current source tree and all fixes were left in place. No Java source was deleted during the handoff.

## Recommended Next Steps

1. Run the exact resume command below and capture the first compiler error, not only the final tail.
2. Fix each decompiler variable-reuse error by giving `HitResult`, `Entity`, `BlockHitResult`, `EntityHitResult`, `BlockPos`, `Vec3d`, and `Item` separate correctly typed locals.
3. Replace remaining intermediary names using the cached Yarn 1.21.11 named mappings or `javap` against the Loom merged Minecraft JAR.
4. Replace any remaining `SwitchBootstraps.typeSwitch` calls with equivalent `instanceof` dispatch while preserving every case body.
5. Repair raw generic collections and typed callback return values.
6. Run the exact compile command after each related group.
7. Once compilation succeeds, run `./gradlew clean build --no-daemon` and verify the produced JAR path before claiming success.

## Resume Command

```bash
./gradlew compileJava --no-daemon
```

## Output Locations

- Complete source tree: `src/`
- Java sources: `src/main/java/`
- Resources/assets: `src/main/resources/`
- This handoff: `TODO.md`
- Intended remapped JAR output after a successful build: `builds/vengeance-client-1.0.0.jar`
