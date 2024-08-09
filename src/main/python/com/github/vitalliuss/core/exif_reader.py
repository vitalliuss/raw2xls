from PIL import Image
from PIL.ExifTags import TAGS
import os

class ExifReader:

    def __init__(self):
        pass

    def read_metadata_from_file(self, file_path):
        try:
            image = Image.open(file_path)
            metadata = {}
            info = image._getexif()
            if info:
                for tag, value in info.items():
                    decoded = TAGS.get(tag, tag)
                    metadata[decoded] = value
            return metadata
        except (IOError, AttributeError) as e:
            print(f'Error reading metadata from file {file_path}: {e}')
            return {}

    def get_list_of_images_from_file_list(self, file_list):
        image_list = []
        for file_path in file_list:
            metadata = self.read_metadata_from_file(file_path)
            image = {"path": file_path, "metadata": metadata}
            image_list.append(image)
        return image_list