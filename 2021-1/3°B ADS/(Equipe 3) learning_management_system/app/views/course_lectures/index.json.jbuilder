# frozen_string_literal: true

json.array! @course_lectures, partial: 'course_lectures/course_lecture', as: :course_lecture
