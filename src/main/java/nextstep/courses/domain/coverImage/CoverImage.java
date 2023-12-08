package nextstep.courses.domain.coverImage;

public class CoverImage {

    private static final int MAX_IMG_SIZE_BYTE = 1048576;

    private Long id;
    private String path;
    private int fileSize;
    private ImageType imageType;
    private Dimensions dimensions;

    public CoverImage(String path, int size, String imgType, int width, int height) {
        if (size > MAX_IMG_SIZE_BYTE || size <= 0) {
            throw new IllegalArgumentException("이미지 크기는 1MB 이하입니다.");
        }

        this.path = path;
        this.fileSize = size;
        this.imageType = ImageType.findType(imgType);
        this.dimensions = new Dimensions(width, height);
    }

    public Long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public int getFileSize() {
        return fileSize;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public CoverImage toSavedCoverImage(Long coverImageId) {
        this.id = coverImageId;
        return this;
    }
}
