# frozen_string_literal: true

class CoursesController < ApplicationController
  before_action :set_course, only: %i[show update edit destroy]

  def index
    @courses = Course.order('created_at DESC')
  end

  def show
    commontator_thread_show(@course)
  end

  def new
    @course = Course.new
  end

  def edit; end

  def create
    @course = Course.new(course_params)

    if @course.save
      flash[:notice] = 'Course was created succesfully.'
      redirect_to @course
    else
      render 'new'
    end
  end

  def update
    if @course.update(course_params)
      flash[:notice] = 'Course was update succesfully.'
      redirect_to @course
    else
      render 'edit'
    end
  end

  def destroy
    @course.destroy
    redirect_to courses_path
  end

  private

  def course_params
    params.require(:course).permit(
      :name,
      :description,
      :cover_picture
    )
  end

  def set_course
    @course = Course.find(params[:id])
  end
end
