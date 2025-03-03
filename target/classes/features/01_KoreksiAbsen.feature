Feature: Pengujian Fitur Koreksi Absen di Aplikasi Hadir

  @test @koreksi @medium @critical @positive
  Scenario: Melakukan koreksi absen setelah melakukan absensi dengan mengisi semua field dengan data Tipe absen "WFO"
    Given Pengguna Login menggunakan email "tejo@gmail.com" dan password "tejo@123"
    And Pengguna melakukan scroll mengarah ke menu koreksi absen
    And Pengguna menekan menu Koreksi Absen
    When Pengguna menekan tombol Ajukan Koreksi
    And Pengguna menekan  field Jam Masuk
    And Pengguna memilih Tahun, Bulan, Tanggal
    And Pengguna memilih Jam dan Menit
    And Pengguna memilih field Jam Keluar
    And Pengguna memilih Tahun, Bulan, Tanggal Jam Keluar
    And Pengguna memilih Jam dan Menit Jam Keluar
    And Pengguna menekan field  Tipe Absen
    And Pengguna memilih WFO
    And Pengguna menekan tombol Ajukan
    Then Pengguna akan melihat text Total akan bertambah

  @test @koreksi @medium @critical @positive
  Scenario: Melakukan koreksi absen setelah melakukan absensi dengan mengisi semua field dengan data Tipe absen "WFH"
    Given Pengguna1 menekan tombol Ajukan Koreksi
    When Pengguna1 menekan  field Jam Masuk
    And Pengguna1 memilih Tahun, Bulan, Tanggal
    And Pengguna1 memilih Jam dan Menit
    And Pengguna1 memilih field Jam Keluar
    And Pengguna1 memilih Tahun, Bulan, Tanggal Jam Keluar
    And Pengguna1 memilih Jam dan Menit Jam Keluar
    And Pengguna1 menekan field  Tipe Absen
    And Pengguna1 memilih WFH
    And Pengguna1 menekan tombol Ajukan
    Then Pengguna1 akan melihat text Total akan bertambah

   @test @koreksi @medium @critical @negative
  Scenario: Melakukan koreksi absen setelah melakukan absensi dengan mengosongkan semua field
    Given Pengguna2 menekan tombol Ajukan Koreksi
    When Pengguna2 menekan tombol Ajukan
    Then Pengguna2 akan melihat alert "Salah satu harus diisi!"

  @test @koreksi @medium @critical @positive
  Scenario: Melakukan koreksi absen dengan mengisi salah satu field yaitu jam masuk saja
    Given Pengguna3 menekan  field Jam Masuk
    When Pengguna3 memilih Tahun, Bulan, Tanggal
    And Pengguna3 memilih Jam dan Menit
    And Pengguna3 menekan tombol Ajukan
    Then Pengguna3 akan melihat text Total akan bertambah
    And Pengguna 3 keluar dari halaman koreksi absen


