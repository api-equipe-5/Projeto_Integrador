class CourseCertificatesController < ApplicationController
  before_action :set_course_certificate, only: %i[ show edit update destroy ]

  # GET /course_certificates or /course_certificates.json
  def index
    @course_certificates = CourseCertificate.all
  end

  # GET /course_certificates/1 or /course_certificates/1.json
  def show
  end

  # GET /course_certificates/new
  def new
    @course_certificate = CourseCertificate.new
  end

  # GET /course_certificates/1/edit
  def edit
  end

  # POST /course_certificates or /course_certificates.json
  def create
    @course_id = params[:course_id]
    @user_id = params[:user_id]
    @course_certificate = CourseCertificate.new(user_id: @user_id, course_id: @course_id)

    respond_to do |format|
      if @course_certificate.save && !already_created?
        format.html { redirect_to @course_certificate, notice: "Course certificate was successfully created." }
        format.json { render :show, status: :created, location: @course_certificate }
      else
        format.html { render :show, status: :unprocessable_entity, location: @course_certificates }
        format.json { render json: @course_certificate.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /course_certificates/1 or /course_certificates/1.json
  def update
    respond_to do |format|
      if @course_certificate.update(course_certificate_params)
        format.html { redirect_to @course_certificate, notice: "Course certificate was successfully updated." }
        format.json { render :show, status: :ok, location: @course_certificate }
      else
        format.html { render :edit, status: :unprocessable_entity }
        format.json { render json: @course_certificate.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /course_certificates/1 or /course_certificates/1.json
  def destroy
    @course_certificate.destroy
    respond_to do |format|
      format.html { redirect_to course_certificates_url, notice: "Course certificate was successfully destroyed." }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_course_certificate
      @course_certificate = CourseCertificate.find(params[:id])
    end

    # Only allow a list of trusted parameters through.
    def course_certificate_params
      params.require(:course_certificate).permit(:user_id, :course_id)
    end

    def already_created?
      CourseCertificate.where(user_id: @user_id, course_id: @course_id).any?
    end
end
