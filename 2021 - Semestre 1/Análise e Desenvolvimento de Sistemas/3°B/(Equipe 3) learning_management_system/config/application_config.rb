# frozen_string_literal: true

Rails.application.configure do
  I18n.config.enforce_available_locales = false
  config.i18n.available_locales = ['pt-BR', :en]
  config.i18n.default_locale = 'pt-BR'
  config.i18n.locale = 'pt-BR'

  config.i18n.load_path += Dir[Rails.root.join('config/locales', '**/*.yml').to_s]

  ENV['RAILS_ADMIN_THEME'] = 'rollincode'
end
