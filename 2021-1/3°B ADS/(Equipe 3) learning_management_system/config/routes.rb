# frozen_string_literal: true

Rails.application.routes.draw do
  mount RailsAdmin::Engine => '/admin', as: 'rails_admin'
  mount Commontator::Engine => '/commontator'
  devise_for :users
  root 'welcome#index'

  resources :courses
  resources :course_lectures
  resources :course_categories
  resources :user_courses
  resources :course_certificates
  resources :events
end
