Feature:Tambah Departements Setting

  @positive @unitSetting
  Scenario: Admin menambahkan departement baru
    Given pengguna3 login dengan email "admin@hadir.com" dan password "admin@hadir"
    And tekan menu management.
    And klik sub menu unit setting
    When Admin tekan tombol hapus pada data yang akan dihapus
    Then Unit setting berhasil dihapus
