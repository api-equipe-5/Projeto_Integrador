require 'test_helper'

class CourseCertificatesControllerTest < ActionDispatch::IntegrationTest
  setup do
    @course_certificate = course_certificates(:one)
  end

  test "should get index" do
    get course_certificates_url
    assert_response :success
  end

  test "should get new" do
    get new_course_certificate_url
    assert_response :success
  end

  test "should create course_certificate" do
    assert_difference('CourseCertificate.count') do
      post course_certificates_url, params: { course_certificate: { course_id: @course_certificate.course_id, user_id: @course_certificate.user_id } }
    end

    assert_redirected_to course_certificate_url(CourseCertificate.last)
  end

  test "should show course_certificate" do
    get course_certificate_url(@course_certificate)
    assert_response :success
  end

  test "should get edit" do
    get edit_course_certificate_url(@course_certificate)
    assert_response :success
  end

  test "should update course_certificate" do
    patch course_certificate_url(@course_certificate), params: { course_certificate: { course_id: @course_certificate.course_id, user_id: @course_certificate.user_id } }
    assert_redirected_to course_certificate_url(@course_certificate)
  end

  test "should destroy course_certificate" do
    assert_difference('CourseCertificate.count', -1) do
      delete course_certificate_url(@course_certificate)
    end

    assert_redirected_to course_certificates_url
  end
end
