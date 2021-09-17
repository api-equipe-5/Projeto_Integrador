# frozen_string_literal: true

class UserCoursesController < ApplicationController
  before_action :set_user_course, only: %i[show edit update destroy]
  before_action :set_courses, only: %i[index]

  # GET /user_courses or /user_courses.json
  def index; end

  # GET /user_courses/1 or /user_courses/1.json
  def show; end

  # GET /user_courses/new
  def new
    @user_course = UserCourse.new
  end

  # GET /user_courses/1/edit
  def edit; end

  # POST /user_courses or /user_courses.json
  def create
    @user_course = UserCourse.new(user_course_params)

    respond_to do |format|
      if @user_course.save
        format.html { redirect_to @user_course, notice: 'User course was successfully created.' }
        format.json { render :show, status: :created, location: @user_course }
      else
        format.html { render :new, status: :unprocessable_entity }
        format.json { render json: @user_course.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /user_courses/1 or /user_courses/1.json
  def update
    respond_to do |format|
      if @user_course.update(user_course_params)
        format.html { redirect_to @user_course, notice: 'User course was successfully updated.' }
        format.json { render :show, status: :ok, location: @user_course }
      else
        format.html { render :edit, status: :unprocessable_entity }
        format.json { render json: @user_course.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /user_courses/1 or /user_courses/1.json
  def destroy
    @user_course.destroy
    respond_to do |format|
      format.html { redirect_to user_courses_url, notice: 'User course was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private

  # Use callbacks to share common setup or constraints between actions.
  def set_user_course
    @user_course = UserCourse.find(params[:id])
  end

  def set_courses
    @courses = current_user.user_course.order('updated_at DESC').map(&:course)
  end

  # Only allow a list of trusted parameters through.
  def user_course_params
    params.require(:user_course).permit(:user_id, :course_id)
  end
end
