# frozen_string_literal: true

class CourseLecture < ApplicationRecord
  has_one_attached :media

  belongs_to :course

  validates :media,
            presence: true

  validates :name,
            presence: true
end
