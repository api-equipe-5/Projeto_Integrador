# frozen_string_literal: true

RailsAdmin.config do |config|
  config.main_app_name = %w[LMS Admin]

  config.parent_controller = 'ApplicationController'

  ## == Devise ==
  config.authenticate_with do
    warden.authenticate! scope: :user
  end
  config.current_user_method(&:current_user)

  ## == CancanCan ==
  config.authorize_with :cancancan

  ## == PaperTrail ==
  # config.audit_with :paper_trail, 'User', 'PaperTrail::Version' # PaperTrail >= 3.0.0

  config.instance_eval(File.read(File.join(Rails.root, 'rails_admin', 'dashboard.rb')))

  model_files = File.join(Rails.root, 'rails_admin', 'models', '**', '*.rb')
  Dir[model_files].each { |model_file| config.instance_eval(File.read(model_file), model_file) }

  config.excluded_models = ['ActiveStorage::Blob', 'ActiveStorage::Attachment', 'UserCourse']
end
