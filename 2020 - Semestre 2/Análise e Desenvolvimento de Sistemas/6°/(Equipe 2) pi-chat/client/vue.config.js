const path = require("path");
const vueSrc = "./src";

module.exports = {
  configureWebpack: {
    resolve: {
      alias: {
        '@': path.resolve(__dirname, vueSrc)
      },
      extensions: [
        '.js',
        '.vue',
        '.json'
      ]
    },
    output: {
      libraryExport: 'default'
    }
  },
  transpileDependencies: [
    'vuetify'
  ]
}
