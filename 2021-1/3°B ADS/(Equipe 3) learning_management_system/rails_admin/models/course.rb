# frozen_string_literal: true

config.model 'Course' do
  parent 'User'

  edit do
    field :name
    field :description, :text
    field :cover_picture
    field :meet_url
    field :course_duration
    field :course_category do
      inline_edit false
    end
  end

  show do
    field :id
    field :name
    field :description
    field :course_duration
    field :created_at
    field :updated_at
  end
end
