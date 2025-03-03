Feature: Pengujian Fitur Izin Terlambat di Aplikasi Hadir Mobile

  @test @izin @terlambat @medium @major @positive
  Scenario: Melakukan pengajuan izin terlambat dengan mengisi semua field dengan data yang valid dan terdapat izin terlambat yang belum di approve
    Given Pengguna melakukan scroll mengarah ke menu izin
    And Pengguna klik menu izin
    When Pengguna klik tombol ajukan izin terlambat
    And Pengguna isi field tanggal
    And Pengguna isi field Jam
    And Pengguna isi field keterangan
    And Pengguna klik tombol ajukan
    Then Muncul notifikasi "Permintaan izin terlambat sebelumnya belum di approve"
    And Pengguna merefresh halaman

  @test @izin @terlambat @medium @major @negative
  Scenario: Melakukan pengajuan izin terlambat dengan mengosongkan semua field
    Given Pengguna1 klik tombol ajukan izin terlambat
    When Pengguna1 klik tombol ajukan
    Then Muncul notifikasi "Tanggal Harus diisi!", "Jam Harus diisi!", "Keterangan Harus diisi!"
    And Pengguna1 merefresh halaman
