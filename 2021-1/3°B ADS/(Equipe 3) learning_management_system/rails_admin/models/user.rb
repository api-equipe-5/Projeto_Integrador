# frozen_string_literal: true

config.model User do
  edit do
    field :username
    field :email
    field :password
    field :role
  end
end
