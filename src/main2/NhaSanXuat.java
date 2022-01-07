package main2;

public class NhaSanXuat {
    private String tenNhaSanXuat;
    private String quocGia;

    public NhaSanXuat(String tenNhaSanXuat, String quocGia) {
        this.tenNhaSanXuat = tenNhaSanXuat;
        this.quocGia = quocGia;
    }

    public String getTenNhaSanXuat() {
        return tenNhaSanXuat;
    }

    public void setTenNhaSanXuat(String tenNhaSanXuat) {
        this.tenNhaSanXuat = tenNhaSanXuat;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }
}
