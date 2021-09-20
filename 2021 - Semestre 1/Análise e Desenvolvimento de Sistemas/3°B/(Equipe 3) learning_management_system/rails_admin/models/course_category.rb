# frozen_string_literal: true

config.model 'CourseCategory' do
  parent 'Course'
  weight(-1)

  edit do
    field :name
    field :cover_picture
  end

  show do
    field :id
    field :name
    field :created_at
    field :updated_at
  end
end
