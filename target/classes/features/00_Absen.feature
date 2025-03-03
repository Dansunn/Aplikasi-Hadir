Feature: Absen Masuk dan Keluar

  Scenario Outline: Absensi masuk dan keluar dan keluar dalam satu hari
    Given User melakukan login dengan "<email>" dan "<password>"
    And User klik tombol Absen Masuk
    And User klik tombol Kamera
    And User mengisi form absen masuk dengan "<status>" dan "<masuk>"
    And User klik tombol Absen Masuk untuk submit absen
    And User menunggu halaman selesai dimuat ulang
    Then User melihat tanggal "Senin, 03 March 2025" pada history absensi
    And User menekan tombol keluar pada history absensi
    And User mengisi "<keluar>" pada bagian notes pulang
    And User klik tombol Absen Keluar
    And User kembali menunggu halaman selesai dimuat ulang
    Then User tidak lagi melihat tombol keluar
    And User melakukan logout
    Examples:
      | email               | password       | status           | masuk   | keluar |
      | hadirsqa38@gmail.com | SQA@Hadir12345 | Work From Home   | Hadir   |        |
      | hadirsqa37@gmail.com | SQA@Hadir12345 | Work From Home   |         | Balik  |
      | hadirsqa36@gmail.com | SQA@Hadir12345 | Work From Office | Hadir   |        |
      | hadirsqa20@gmail.com | SQA@Hadir12345 | Work From Office |         | Balik  |

  @Negative
  Scenario: Mencoba kembali absen masuk setelah sudah melakukan absen masuk sebelumnya
  Given User melakukan login dengan email "hadirsqa16@gmail.com" dan password "SQA@Hadir12345"
  Then User mencoba mencari tombol masuk dan tombol masuk sudah tidak ada

  @Negative
  Scenario: Mencoba kembali absen keluar setelah sudah melakukan absen keluar sebelumnya
    Given User mencoba mencari tombol keluar
    Then  Ternyata tombol keluar sudah tidak ada


#
#  Scenario Outline: Absen masuk dengan dua kali dalam satu hari
#    Given User melakukan login kembali dengan <email> dan <password>
#    And User tidak melihat tombol absen masuk karena sudah absen
#    And User yang ingin absen melakukan logout
#
#    Examples:
#      | email               | password       |
#      | hadirsqa9@gmail.com | SQA@Hadir12345 |
#      | hadirsqa8@gmail.com | SQA@Hadir12345 |
#      | hadirsqa6@gmail.com | SQA@Hadir12345 |
#      | hadirsqa7@gmail.com | SQA@Hadir12345 |
#
#  Scenario Outline: Absensi keluar
#    Given User yang sudah absen melakukan login dengan <email> dan <password>
#    And User menekan tombol keluar pada history absensi
#    And User mengisi <catatan> pada bagian notes pulang
#    And User menekan tombol Absen Keluar
#    Then User tidak lagi melihat tombol Absen Keluar
#    And User kembali melakukan logout
#
#    Examples:
#      | email               | password       | catatan |
#      | hadirsqa9@gmail.com | SQA@Hadir12345 | Balik   |
#      | hadirsqa8@gmail.com | SQA@Hadir12345 |         |
#      | hadirsqa6@gmail.com | SQA@Hadir12345 | Balik   |
#      | hadirsqa7@gmail.com | SQA@Hadir12345 |         |



