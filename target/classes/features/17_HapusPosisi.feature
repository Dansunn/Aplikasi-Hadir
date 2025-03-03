Feature:Tambah Posisi

  @positive @posisi
  Scenario: Admin hapus posisi
    Given pengguna11 login dengan email "admin@hadir.com" dan password "admin@hadir"
    And tekan menu management,
    And Pengguna tekan sub menu posisi,
    When Admin klik titik tiga pada posisi yang akan dihapus,
    And Admin klik hapus
    And Admin klik tombol ya
    Then Data terhapus