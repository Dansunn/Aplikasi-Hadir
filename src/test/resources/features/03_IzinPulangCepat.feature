Feature:Pengujian Fitur Izin Pulang Cepat di Aplikasi Hadir Mobile

  @test @izin @pulangCepat @medium @major @positive
  Scenario: Melakukan pengajuan izin pulang cepat dengan mengisi semua field dengan data yang valid
    Given Pengguna1 klik tombol pulang cepat dihalaman izin
    When Pengguna1 klik tombol ajukan izin pulang cepat
    And Pengguna1 isi field tanggal
    And Pengguna1 isi field Jam
    And Pengguna1 isi field keterangan
    And Klik tombol ajukan
    Then Text Total akan bertambah

  @test @izin @pulangCepat @medium @major @negative
  Scenario: Melakukan pengajuan izin pulang cepat dengan mengosongkan semua field
    Given Pengguna2 klik tombol ajukan izin pulang cepat
    When Pengguna2 klik tombol ajukan
    Then Muncul pesan error "Tanggal Harus diisi!", "Jam Harus diisi!", "Keterangan Harus diisi!"
    And Pengguna2 merefresh halaman