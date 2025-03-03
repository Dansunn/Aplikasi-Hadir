Feature:Pengujian Fitur Izin Off di Aplikasi Hadir Mobile

  @test @izin @off @medium @critical @positive
  Scenario: Melakukan pengajuan izin off dan mengisi semua field dengan kondisi terdapat data yang belum di approve
    Given Pengguna klik tombol izin off dihalaman izin
    When Pengguna klik tombol ajukan izin off
    And Pengguna mengisi tanggal izin off
    And Pengguna mengisi field alasan off
    And Klik tombol ajukan setelah mengisi semua field
    Then Akan muncul alert "Permintaan dalam proses"
    And Pengguna merefresh halaman izin off

  @test @izin @off @medium @critical @negative
  Scenario: Melakukan pengajuan izin Off dengan mengosongkan semua field
    Given Pengguna1 menekan tombol ajukan izin off
    When Pengguna1 langsung menekan tombol ajukan
    Then Muncul pesan error "Pilih tanggal off!.", "Alasan dan mengambill izin off."
    And Pengguna1 merefresh halaman izin off