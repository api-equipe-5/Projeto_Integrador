# frozen_string_literal: true

class CourseCategory < ApplicationRecord
  has_one_attached :cover_picture

  has_many :courses

  validates :name,
            presence: true
end
