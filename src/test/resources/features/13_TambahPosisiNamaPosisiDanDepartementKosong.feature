Feature:Tambah Posisi

  @negative @posisi
  Scenario: Admin menambahkan posisi baru
    Given pengguna7 login dengan email "admin@hadir.com" dan password "admin@hadir"
    And pengguna klik menu management
    And pengguna tekan sub menu posisi
    When pengguna menekan tombol tambahkan
    And pengguna menekan tombol tambah
    Then pengguna gagal menambahkan data