package nextstep.courses.domain.session.image;

import java.util.Objects;

public class CoverImage {

    private final Long id;
    private final ImageType type;
    private final Size size;
    private final Dimensions dimensions;
    private final Long sessionId;

    public CoverImage(
            final Long id,
            final ImageType type,
            final Size size,
            final Dimensions dimensions,
            final Long sessionId
    ) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.dimensions = dimensions;
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(final Object otherCoverImage) {
        if (this == otherCoverImage) {
            return true;
        }

        if (otherCoverImage == null || getClass() != otherCoverImage.getClass()) {
            return false;
        }

        final CoverImage that = (CoverImage)otherCoverImage;

        return Objects.equals(id, that.id) &&
                type == that.type &&
                Objects.equals(size, that.size) &&
                Objects.equals(dimensions, that.dimensions) &&
                Objects.equals(sessionId, that.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.type, this.size, this.dimensions, this.sessionId);
    }
}
