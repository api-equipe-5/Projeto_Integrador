# frozen_string_literal: true

config.model 'CourseLecture' do
  parent 'Course'
  weight(-2)

  edit do
    field :name
    field :course do
      inline_add false
      inline_edit false
    end
    field :media
  end
end
