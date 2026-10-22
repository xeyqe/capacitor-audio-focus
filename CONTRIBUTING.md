# Contributing

This guide provides instructions for contributing to this Capacitor plugin.

## Developing

### Local Setup

Use Node.js 22.13 or newer, JDK 21, and Android SDK 36. The Gradle wrapper
provides Gradle 8.14.5. The plugin requires Android API 26 because it uses
`AudioFocusRequest`.

TypeScript stays on the 6.0 release line until the ESLint TypeScript parser
supports TypeScript 7.

Docgen uses its bundled TypeScript 4 compiler and a separate
`tsconfig.docgen.json` to keep generated API types accurate.

1. Fork and clone the repo.
1. Install the dependencies.

    ```shell
    npm install
    ```

### Scripts

#### `npm run build`

Build the plugin web assets and generate plugin API documentation using [`@capacitor/docgen`](https://github.com/ionic-team/capacitor-docgen).

It will compile the TypeScript code from `src/` into ESM JavaScript in `dist/esm/`. These files are used in apps with bundlers when your plugin is imported.

Then, Rollup will bundle the code into a single file at `dist/plugin.js`. This file is used in apps without bundlers by including it as a script in `index.html`.

#### `npm run verify`

Build and validate the web and native projects.

This is useful to run in CI to verify that the plugin builds for all platforms.

To check the example app after building the plugin, run `npm ci --prefix example`
and `npm run build --prefix example`.

#### `npm run lint` / `npm run fmt`

Check formatting and code quality, autoformat/autofix if possible.

This template is integrated with ESLint, and Prettier. Using these tools is completely optional, but the [Capacitor Community](https://github.com/capacitor-community/) strives to have consistent code style and structure for easier cooperation.

## Publishing

There is a `prepublishOnly` hook in `package.json` which prepares the plugin before publishing, so all you need to do is run:

```shell
npm publish
```

> **Note**: The [`files`](https://docs.npmjs.com/cli/v7/configuring-npm/package-json#files) array in `package.json` specifies which files get published. If you rename files/directories or add files elsewhere, you may need to update it.
