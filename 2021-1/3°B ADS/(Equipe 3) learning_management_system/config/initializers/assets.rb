# frozen_string_literal: true

# Be sure to restart your server when you modify this file.

# Version of your assets, change this if you want to expire all your assets.
Rails.application.config.assets.version = '1.0'

# Add additional assets to the asset load path.
# Rails.application.config.assets.paths << Emoji.images_path
# Add Yarn node_modules folder to the asset load path.
Rails.application.config.assets.paths << Rails.root.join('node_modules')

# Precompile additional assets.
# application.js, application.css, and all non-JS/CSS in the app/assets
# folder are already added.
# Rails.application.config.assets.precompile += %w( admin.js admin.css )
Rails.application.config.assets.precompile += [
  'portfolio/logo_transparent2.png',
  'portfolio/amd.png',
  'portfolio/bd.png',
  'portfolio/logistica.png',
  'portfolio/manutencao.png',
  'portfolio/pea.png',
  'portfolio/gpi.png',
  'portfolio/person.png',
  'portfolio/default_category.png',
  'portfolio/meet-logo.png',
  'portfolio/bi-logo.png',
  'sketch-design-mobile.svg'
]
