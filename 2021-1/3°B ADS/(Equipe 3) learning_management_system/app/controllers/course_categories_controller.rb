# frozen_string_literal: true

class CourseCategoriesController < ApplicationController
  before_action :set_course_category, only: %i[show edit update destroy]

  def index
    @course_categories = CourseCategory.all
  end

  def show; end

  def new
    @course_category = CourseCategory.new
  end

  def edit; end

  def create
    @course_category = CourseLecture.new(course_category_params)

    respond_to do |format|
      if @course_category.save
        format.html { redirect_to @course_category, notice: 'Course lecture was successfully created.' }
        format.json { render :show, status: :created, location: @course_category }
      else
        format.html { render :new, status: :unprocessable_entity }
        format.json { render json: @course_category.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /course_categorys/1 or /course_categorys/1.json
  def update
    respond_to do |format|
      if @course_category.update(course_category_params)
        format.html { redirect_to @course_category, notice: 'Course lecture was successfully updated.' }
        format.json { render :show, status: :ok, location: @course_category }
      else
        format.html { render :edit, status: :unprocessable_entity }
        format.json { render json: @course_category.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /course_categorys/1 or /course_categorys/1.json
  def destroy
    @course_category.destroy
    respond_to do |format|
      format.html { redirect_to course_lectures_url, notice: 'Course lecture was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private

  # Use callbacks to share common setup or constraints between actions.
  def set_course_category
    @course_category = CourseCategory.find(params[:id])
  end

  # Only allow a list of trusted parameters through.
  def course_category_params
    params.require(:course_category).permit(:name)
  end
end
