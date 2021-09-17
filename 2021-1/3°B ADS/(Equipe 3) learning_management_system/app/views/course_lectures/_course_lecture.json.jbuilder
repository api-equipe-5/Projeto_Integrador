# frozen_string_literal: true

json.extract! course_lecture, :id, :type, :content, :course_id, :created_at, :updated_at
json.url course_lecture_url(course_lecture, format: :json)
