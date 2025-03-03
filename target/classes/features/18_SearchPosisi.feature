Feature:Tambah Posisi

  @positive @posisi
  Scenario: Admin hapus posisi
    Given pengguna12 login dengan email "admin@hadir.com" dan password "admin@hadir"
    And Admin tekan menu management,
    And Pengguna tekan sub menu posisi.
    When Ketik nama Admin 2
    And Klik tombol search
    Then Data Ditemukan