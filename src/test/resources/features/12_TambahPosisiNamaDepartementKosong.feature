Feature:Tambah Posisi departemen kosong

  @negative @posisi
  Scenario: Admin menambahkan posisi baru
    Given pengguna6 login dengan email "admin@hadir.com" dan password "admin@hadir"
    And pengguna tekan menu management
    And tekan sub menu posisi
    When menekan tombol tambahkan
    And mengisi posisi Admin 1
    And menekan tombol tambah
    Then Data gagal ditambahkan