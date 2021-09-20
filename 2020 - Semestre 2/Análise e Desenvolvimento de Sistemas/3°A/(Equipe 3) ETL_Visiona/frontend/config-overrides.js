/* config-overrides.js */
const { override, addLessLoader } = require('customize-cra');

module.exports = override(
  addLessLoader({
    // If you are using less-loader@5 or older version, please spread the lessOptions to options directly.
    lessOptions: {
      javascriptEnabled: true,
      modifyVars: { '@base-color': '#373A52',
       '@B000': '#00FFE0',
       '@B300': '#326296',
       '@B400': '#224f80',
       'text-color': '#000000',
       '@B200': '#00E5CA',
       '@modal-border-radius': '0px',
       '@modal-content-bg': 'rgba(86, 204, 242, 0.5)',
       '@modal-box-shadow': '0px 4px 77px 9px rgba(0, 0, 0, 0.25)'
      }
    }
  })
);