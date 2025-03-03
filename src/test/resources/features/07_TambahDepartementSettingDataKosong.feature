Feature:Tambah Departements Setting Data Kosong
  @negative @unitSetting
  Scenario: Admin menambahkan departement baru dengan data kosong
    Given Pengguna login dengan email "admin@hadir.com" dan password "admin@hadir"
    And klik menu management
    And Admin tekan sub menu unit setting
    When Admin klik tombol tambahkan
    And Admin mengisi dengan data kosong
    And Admin klik tombol tambah
    Then Unit setting gagal ditambahkan