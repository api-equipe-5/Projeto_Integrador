require "application_system_test_case"

class CourseCertificatesTest < ApplicationSystemTestCase
  setup do
    @course_certificate = course_certificates(:one)
  end

  test "visiting the index" do
    visit course_certificates_url
    assert_selector "h1", text: "Course Certificates"
  end

  test "creating a Course certificate" do
    visit course_certificates_url
    click_on "New Course Certificate"

    fill_in "Course", with: @course_certificate.course_id
    fill_in "User", with: @course_certificate.user_id
    click_on "Create Course certificate"

    assert_text "Course certificate was successfully created"
    click_on "Back"
  end

  test "updating a Course certificate" do
    visit course_certificates_url
    click_on "Edit", match: :first

    fill_in "Course", with: @course_certificate.course_id
    fill_in "User", with: @course_certificate.user_id
    click_on "Update Course certificate"

    assert_text "Course certificate was successfully updated"
    click_on "Back"
  end

  test "destroying a Course certificate" do
    visit course_certificates_url
    page.accept_confirm do
      click_on "Destroy", match: :first
    end

    assert_text "Course certificate was successfully destroyed"
  end
end
