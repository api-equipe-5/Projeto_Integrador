# frozen_string_literal: true

class CourseLecturesController < ApplicationController
  before_action :set_course_lecture, only: %i[show edit update destroy]
  before_action :set_course, only: %i[show]
  before_action :add_course_to_user, only: %i[show]
  before_action :set_course_certificate, only: %i[ show edit update destroy ]

  # GET /course_lectures or /course_lectures.json
  def index
    @course_lectures = CourseLecture.all
  end

  # GET /course_lectures/1 or /course_lectures/1.json
  def show; end

  # GET /course_lectures/new
  def new
    @course_lecture = CourseLecture.new
  end

  # GET /course_lectures/1/edit
  def edit; end

  # POST /course_lectures or /course_lectures.json
  def create
    @course_lecture = CourseLecture.new(course_lecture_params)

    respond_to do |format|
      if @course_lecture.save
        format.html { redirect_to @course_lecture, notice: 'Course lecture was successfully created.' }
        format.json { render :show, status: :created, location: @course_lecture }
      else
        format.html { render :new, status: :unprocessable_entity }
        format.json { render json: @course_lecture.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /course_lectures/1 or /course_lectures/1.json
  def update
    respond_to do |format|
      if @course_lecture.update(course_lecture_params)
        format.html { redirect_to @course_lecture, notice: 'Course lecture was successfully updated.' }
        format.json { render :show, status: :ok, location: @course_lecture }
      else
        format.html { render :edit, status: :unprocessable_entity }
        format.json { render json: @course_lecture.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /course_lectures/1 or /course_lectures/1.json
  def destroy
    @course_lecture.destroy
    respond_to do |format|
      format.html { redirect_to course_lectures_url, notice: 'Course lecture was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private

  # Use callbacks to share common setup or constraints between actions.
  def set_course_lecture
    @course_lecture = CourseLecture.find(params[:id])
  end

  def set_course_certificate
    @course_certificate = CourseCertificate.where(user_id: current_user.id, course_id: @course.id).first
  end

  def set_course
    @course = @course_lecture.course
  end

  # Only allow a list of trusted parameters through.
  def course_lecture_params
    params.require(:course_lecture).permit(:type, :content, :course_id)
  end

  def add_course_to_user
    if course_already_registered?
      current_user.user_course.where(course_id: @course.id).take.touch
    else
      UserCourse.create!(user_id: current_user.id, course_id: @course.id)
    end
  end

  def course_already_registered?
    current_user.user_course.where(course_id: @course.id).any?
  end
end
